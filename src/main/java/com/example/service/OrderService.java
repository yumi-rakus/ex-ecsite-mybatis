package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.repository.OrderRepository;

/**
 * 注文情報を操作するサービス.
 * 
 * @author yumi takahashi
 *
 */
@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	/**
	 * 未注文（status=0）のレコードが存在するかどうかを返す.
	 * 
	 * @param userId ユーザID
	 * @return status = 0 (未注文)のレコードが存在していればtrue、存在していなければfalseを返す
	 */
	public boolean existsByStatus0ByUserId(Integer userId) {
		Integer count = orderRepository.existsByStatus0ByUserId(userId);

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 未注文（status=0）の注文IDを取得する.
	 * 
	 * @param userId ユーザID
	 * @return 注文ID
	 */
	public Integer getOrderIdByUserIdByStatus0(Integer userId) {
		return orderRepository.findOrderIdByUserIdByStatus0(userId);
	}

	/**
	 * 未注文（status=0）の注文情報を挿入する.
	 * 
	 * @param order 注文情報
	 * @return 注文情報
	 */
	public void insertOrder(Order order) {
		orderRepository.insertOrder(order);
	}

	/**
	 * ショッピングカートリストを取得する.
	 * 
	 * @param userId ユーザID
	 * @return カートの商品一覧
	 */
	public List<Order> getOrderListByUserIdByStatus0(Integer userId) {

		return orderRepository.findByUserIdByStatus0(userId);
	}

	/**
	 * 合計金額を更新する.
	 * 
	 * @param userId ユーザID
	 */
	public void updateTotalPrice(Integer userId) {
		List<Order> order = getOrderListByUserIdByStatus0(userId);
		Integer totalPrice = order.get(0).getCalcTotalPrice();
		orderRepository.updateTotalPriceByUserIdByStatus0(totalPrice, userId);
	}

	/**
	 * 注文情報を未注文から注文済みに更新する.
	 * 
	 * @param order 注文情報
	 */
	public void updateOrderByUserIdByStatus0(Order order) {
		orderRepository.updateOrderByUserIdByStatus0(order);
	}

	/**
	 * 注文履歴を取得する.
	 * 
	 * @param userId ユーザID
	 * @return カートの商品一覧
	 */
	public List<Order> getOrderHistoryListByUserIdByStatusNon0(Integer userId) {

		return orderRepository.findByUserIdByStatusNot0(userId);
	}

	/**
	 * order_itemsのorder_idをログインユーザのstatus = 0のものに変更する.
	 * 
	 * @param uuidOrderId UUIDのorder_id
	 * @param userOrderId ログインユーザのorder_id
	 */
	public void updateOrderId(Integer uuidOrderId, Integer userOrderId) {
		orderRepository.updateOrderId(uuidOrderId, userOrderId);
	}

	/**
	 * ログイン前に作成した仮のレコードを削除.
	 * 
	 * @param uuid UUID
	 */
	public void deleteUuidRecordByUuid(Integer uuid) {
		orderRepository.deleteUuidRecordByUuid(uuid);
	}

	/**
	 * UUID(仮UserId)をログイン後のUserIdに更新する.
	 * 
	 * @param userId ユーザID
	 * @param uuid   UUID
	 */
	public void updateUserId(Integer userId, Integer uuid) {
		orderRepository.updateUserId(userId, uuid);
	}
}
