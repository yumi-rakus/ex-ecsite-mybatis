package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.User;

/**
 * usersテーブルを操作するリポジトリ.
 * 
 * @author yumi takahashi
 *
 */
@Mapper
public interface UserRepository {

	/**
	 * メールアドレスが既に登録されているものかどうかを判定する.
	 * 
	 * @param email メールアドレス
	 * @return 既に登録されていればtrue, 登録されていなければfalseを返す
	 */
	public Integer existEmail(String email);

	/**
	 * メールアドレスからユーザ情報を取得する.
	 * 
	 * @param email メールアドレス
	 * @return ユーザ情報
	 */
	public List<User> findByEmail(String email);

	/**
	 * ユーザ情報を挿入する.
	 * 
	 * @param user ユーザ情報
	 */
	public void insert(User user);

	/**
	 * IDからユーザ情報を取得する.
	 * 
	 * @param id ユーザID
	 * @return ユーザ情報
	 */
	public List<User> findById(Integer id);
}
