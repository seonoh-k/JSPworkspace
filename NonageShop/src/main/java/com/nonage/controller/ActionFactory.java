package com.nonage.controller;


import com.nonage.admin.controller.action.*;
import com.nonage.controller.action.*;

public class ActionFactory {
    private static ActionFactory instance = new ActionFactory();

    private ActionFactory() {
        super();
    }

    public static ActionFactory getInstance() {
        return instance;
    }

    public Action getAction(String command) {

        Action action = null;

        // 메인페이지 IndexAction
        if(command.equals("index")) {
            action = new IndexAction();
        }else if(command.equals("product_detail")) {
            action = new ProductDetailAction();
        }else if(command.equals("category")) {
            action = new ProductKindAction();
        }else if(command.equals("contract")) {
            action = new ContractAction();
        }else if(command.equals("join_form")) {
            action = new JoinFormAction();
        }else if(command.equals("join")) {
            action = new JoinAction();
        }else if(command.equals("id_check_form")) {
            action = new IdCheckFormAction();
        }else if(command.equals("find_zip_num")) {
            action = new FindZipNumAction();
        }else if(command.equals("login_form")) {
            action = new LoginFormAction();
        }else if(command.equals("login")) {
            action = new LoginAction();
        }else if(command.equals("logout")) {
            action = new LogoutAction();
        }else if(command.equals("cart_insert")) {
            action = new CartInsertAction();
        }else if(command.equals("cart_list")) {
            action = new CartListAction();
        }else if(command.equals("cart_delete")) {
            action = new CartDeleteAction();
        }else if(command.equals("mypage")) {
            action = null;
        }else if(command.equals("order_insert")) {
            action = new OrderInsertAction();
        }else if(command.equals("order_list")) {
            action = new OrderListAction();
        }else if(command.equals("order_delete")) {
            action = null;
        }else if(command.equals("order_all")) {
            action = null;
        }else if(command.equals("qna_list")) {
            action = new QnaListAction();
        }else if(command.equals("qna_write_form")) {
            action = new QnaWriteFormAction();
        }else if(command.equals("qna_write")) {
            action = new QnaWriteAction();
        }else if(command.equals("qna_view")) {
            action = new QnaViewAction();
        }else if(command.equals("admin_login_form")) {
            action = new AdminLoginFormAction();
        }else if(command.equals("admin_login")) {
            action = new AdminLoginAction();
        }else if(command.equals("admin_logout")) {
            action = new AdminLogoutAction();
        }else if(command.equals("admin_product_list")) {
            action = new AdminProductListAction();
        }else if(command.equals("admin_product_detail")) {
            action = new AdminProductDetailAction();
        }else if(command.equals("admin_product_insert_form")) {
            action = new AdminProductInsertFormAction();
        }else if(command.equals("admin_product_insert")) {
            action = new AdminProductInsertAction();
        }else if(command.equals("admin_product_search")) {
            action = new AdminProductSearchAction();
        }else if(command.equals("admin_product_update")) {
            action = new AdminProductUpdateAction();
        }else if(command.equals("admin_product_update_form")) {
            action = new AdminProductUpdateFormAction();
        }else if(command.equals("admin_qna_list")) {
            action = new AdminQnaListAction();
        }else if(command.equals("admin_qna_detail")) {
            action = new AdminQnaDetailAction();
        }else if(command.equals("admin_qna_insertReply")) {
            action = new AdminQnaInsertReplyAction();
        }else if(command.equals("admin_qna_insertReply_form")) {
            action = new AdminQnaInsertReplyFormAction();
        }else if(command.equals("admin_order_list")) {
            action = new AdminOrderListAction();
        }else if(command.equals("admin_order_search")) {
            action = new AdminOrderSearchAction();
        }else if(command.equals("admin_order_detail")) {
            action = new AdminOrderDetailAction();
        }

        return action;
    }
}
