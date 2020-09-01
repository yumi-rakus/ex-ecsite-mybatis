package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Order;

/**
 * ordersテーブルを操作するリポジトリ.
 * 
 * @author yumi takahashi
 *
 */
@Mapper
public interface OrderRepository {

	/**
	 * 未注文（status=0）のレコードが存在するかどうかを返す.
	 * 
	 * @param userId ユーザID
	 * @return status = 0 (未注文)のレコードが存在していればtrue、存在していなければfalseを返す
	 */
	public Integer existsByStatus0ByUserId(Integer userId);

	/**
	 * 未注文（status=0）の注文IDを取得する.
	 * 
	 * @param userId ユーザID
	 * @return 注文ID
	 */
	public Integer findOrderIdByUserIdByStatus0(Integer userId);

	/**
	 * 未注文（status=0）の注文情報を挿入する.
	 * 
	 * @param order 注文情報
	 * @return 注文情報
	 */
	public void insertOrder(Order order);

	/**
	 * 未注文（status=0）の注文リストを取得する.
	 * 
	 * @param userId ユーザID
	 * @return 未注文の注文情報
	 */
	public List<Order> findByUserIdByStatus0(Integer userId);

	/**
	 * 合計金額を更新する.
	 * 
	 * @param totalPrice 合計金額
	 * @param userId     ユーザID
	 */
	public void updateTotalPriceByUserIdByStatus0(Integer totalPrice, Integer userId);

	/**
	 * 注文情報を未注文から注文済みに更新する.
	 * 
	 * @param order 注文情報
	 */
	public void updateOrderByUserIdByStatus0(Order order);

	/**
	 * 注文済の注文リストを取得する.
	 * 
	 * @param userId ユーザID
	 * @return 注文済の注文情報
	 */
	public List<Order> findByUserIdByStatusNot0(Integer userId);

	/**
	 * order_itemsのorder_idをログインユーザのstatus = 0のものに変更する.
	 * 
	 * @param uuidOrderId UUIDのorder_id
	 * @param userOrderId ログインユーザのorder_id
	 */
	public void updateOrderId(Integer uuidOrderId, Integer userOrderId);

	/**
	 * ログイン前に作成した仮のレコードを削除.
	 * 
	 * @param uuid UUID
	 */
	public void deleteUuidRecordByUuid(Integer uuid);

	/**
	 * UUID(仮UserId)をログイン後のUserIdに更新する.
	 * 
	 * @param userId ユーザID
	 * @param uuid   UUID
	 */
	public void updateUserId(Integer userId, Integer uuid);

}
