package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.OrderItem;

/**
 * order_itemsテーブルを操作するリポジトリ.
 * 
 * @author yumi takahashi
 *
 */
@Mapper
public interface OrderItemRepository {

	/**
	 * 注文商品情報を挿入する.
	 * 
	 * @param orderItem 注文商品情報
	 * @return 注文商品情報
	 */
	public void insertOrderItem(OrderItem orderItem);

	/**
	 * 注文商品情報及び付随する注文トッピング情報を削除する.
	 * 
	 * @param orderItemId 注文商品ID
	 */
	public void deleteByOrderItemId(Integer orderItemId);

}
