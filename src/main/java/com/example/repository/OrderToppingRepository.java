package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.OrderTopping;

/**
 * order_toppingsテーブルを操作するリポジトリ.
 * 
 * @author yumi takahashi
 *
 */
@Mapper
public interface OrderToppingRepository {

	/**
	 * 注文トッピング情報を挿入する.
	 * 
	 * @param orderTopping 注文トッピング情報
	 */
	public void insertOrderTopping(OrderTopping orderTopping);

	/**
	 * 注文トッピング情報を削除する.
	 * 
	 * @param orderItemId 注文商品ID
	 */
	public void deleteByOrderItemId(Integer orderItemId);

}
