package com.cadastro1.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro1.exception.ErroAutenticacao;
import com.cadastro1.exception.RegraNegocioException;
import com.cadastro1.model.entity.Usuario;
import com.cadastro1.repositories.UsuarioRepository;
import com.cadastro1.services.UsuarioService;

@Service     // ao colocar o mouse em UsuarioServiceImpl e clicar Add unimplemented methods ele cria tudo pra gente ir auto implementando
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired  // Aqui ele cria os construtores automaticamente
	private UsuarioRepository repository;  // aqui ele tá instanciando. Chamamos o repository porque é ele que vai fazer a comunicação com obanco
		
	@Override
	public Usuario autenticar(String email, String senha) {
		// esse optional é um array ou seja é uma lista
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		// ao colocar o email e senha aqui ele verifica se tem um email e senha presente ou não caso não existe (cadastrado) ele já será barrado aqui
		// Tudo que for pra negar usamaos a ! na frente
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado.");
		}
		
		// tudo isso aqui pode ser feito junto com o de cima porém não saberá onde errou se foi no email ou senha
		if (!usuario.get() .getSenha () .equals(senha)) {
			throw new ErroAutenticacao("Senha incorreta.");
		}
		
		return usuario.get();
	}

	@Override
	@Transactional  // usar essa função é pra quando se manipula o banco ou seja aqui ele tá indo e voltando no banco
					// caso seja feita apenas uma consulta não se coloca nada
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());  // quando colocar o email ele vai verificar se já existe ou não no validarEmail criado abaixo
		// aqui ele tá chamando o repository e esse usuario no save é o que foi feito acima
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		// aqui é só pra saber se o Email existe caso não exista ele passa direto e caso exista aparecerá a msg abaixo
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com esse e-mail.");
		}
		
	}

	@Override
	public Optional<Usuario> buscarPorId(Long id) {
		// o findById é pra encontrar o in que está no Long
		return repository.findById(id);
	}

}

