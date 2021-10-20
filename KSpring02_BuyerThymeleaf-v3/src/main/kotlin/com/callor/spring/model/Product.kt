package com.callor.spring.model

data class Product(
    val p_id: String, val p_mId:String, val p_name: String, val p_price: Int,
    val p_qty: Int, val p_total:Int = p_price * p_qty
) {
}

//<tr th:each="product : ${products}" th:data-id="${product.p_id}">
//<td th:text="${index}">1</td>
//<td th:text="${product.p_name}">커피라떼는</td>
//<td th:text="${product.p_price}">2000</td>
//<td th:text="${product.p_qty}">20</td>
//<td th:text="${product.p_total}">40000</td>