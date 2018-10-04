package br.com.ricardoludwig.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoludwig.user.domain.Email;
import br.com.ricardoludwig.user.domain.User;
import br.com.ricardoludwig.user.model.UserModel;
import br.com.ricardoludwig.user.repository.UserModelRepository;
import br.com.ricardoludwig.user.repository.exception.UserAlreadyExistException;
import br.com.ricardoludwig.user.repository.exception.UserNotFoundException;
import br.com.ricardoludwig.user.util.StringUtils;

@Service
public class UserService {

	private UserModelRepository repository;

	@Autowired
	public UserService(UserModelRepository $repository) {
		if ($repository == null)
			throw new IllegalArgumentException("user repository not found.");
		repository = $repository;
	}

	public User updateOne(User user) {
		return createOne(user);
	}

	public User createOne(final User user) {

		UserModel entity = UserModel.valueOf(user);
		entity = repository.save(entity);
		User saved = getUser(entity);

		return saved;
	}

	public void hasPersistedLogin(final User user) {
		Email usermane = user.getUsername();
		try {
			findEntityByUsername(usermane.toString());
		} catch (UserNotFoundException e) {
			return;
		} catch (Exception e) {
			throw new IllegalArgumentException("invalid.state.fail.insert.login");
		}

		throw new UserAlreadyExistException();
	}

	public User disableBy(String login) {
		UserModel entity = findEntityByUsername(login);
		entity.setActivated(false);
		repository.save(entity);
		return getUser(entity);
	}

	public User findBy(String username) {
		UserModel entity = findEntityByUsername(username);
		return getUser(entity);

	}

	private UserModel findEntityByUsername(String username) {
		UserModel entity = repository.findByUsername(username);
		if (entity == null || StringUtils.isEmpty(username)) {
			throw new UserNotFoundException();
		}
		return entity;
	}

	private User getUser(UserModel entity) {
		if (entity == null)
			throw new UserNotFoundException();
		return User.valueOf(entity);
	}

}
