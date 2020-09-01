package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * ユーザ情報を操作するサービス.
 * 
 * @author yumi takahashi
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * メールアドレスが既に登録されているものかどうかを判定する.
	 * 
	 * @param email メールアドレス
	 * @return 既に登録されていればtrue, 登録されていなければfalseを返す
	 */
	public boolean existEmail(String email) {
		Integer count = userRepository.existEmail(email);

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * メールアドレスからユーザ情報を取得する.
	 * 
	 * @param email メールアドレス
	 * @return ユーザ情報
	 */
	public User findByEmail(String email) {

		boolean judge = existEmail(email);

		if (judge) {

			List<User> user = userRepository.findByEmail(email);

			return user.get(0);
		} else {
			return new User();
		}
	}

	/**
	 * ユーザを新規登録する.
	 * 
	 * @param user ユーザ情報
	 */
	public void insert(User user) {
		// passwordのハッシュ化
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepository.insert(user);
	}

	/**
	 * IDからユーザ情報を取得する.
	 * 
	 * @param id ユーザID
	 * @return ユーザ情報
	 */
	public User findById(Integer id) {
		return userRepository.findById(id).get(0);
	}

}
