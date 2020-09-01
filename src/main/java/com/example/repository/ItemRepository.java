package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Item;

/**
 * itemsテーブルを操作するリポジトリ.
 * 
 * @author yumi takahashi
 *
 */
@Mapper
public interface ItemRepository {

	/**
	 * （削除フラグが立っていない）全商品情報をID順で取得する.
	 * 
	 * @return 全商品情報一覧
	 */
	List<Item> findAll(Integer offset);

	/**
	 * 商品情報を取得する.
	 * 
	 * @param id 商品ID
	 * @return 商品情報
	 */
	Item load(Integer id);

	/**
	 * 商品を曖昧検索する.
	 * 
	 * @param name 検索キー
	 * @return 検索結果商品一覧
	 */
	List<Item> findByNameContainingByDeletedFalse(String name, Integer offset);

	/**
	 * （削除フラグが立っていない）商品名をID順で取得する.
	 * 
	 * @param name 検索キー
	 * @return 商品名リスト
	 */
	List<String> getNameList(String name);

	/**
	 * （削除フラグが立っていない）商品件数を取得する.
	 * 
	 * @return 商品件数
	 */
	Integer getCount();

	/**
	 * （削除フラグが立っていない）検索された商品件数を取得する.
	 * 
	 * @param name 検索キー
	 * @return 商品件数
	 */
	Integer getSearchCount(String name);
}
