package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Topping;

/**
 * toppingsテーブルを操作するリポジトリ.
 * 
 * @author yumi takahashi
 *
 */
@Mapper
public interface ToppingRepository {

	/**
	 * 全トッピング情報をID順で取得する.
	 * 
	 * @return 全トッピング情報一覧
	 */
	public List<Topping> findAll();
}
