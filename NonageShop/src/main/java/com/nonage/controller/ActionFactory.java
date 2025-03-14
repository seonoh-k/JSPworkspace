package com.nonage.controller;


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
        }else if(command.equals("admin_login_form")) {
            action = null;
        }else if(command.equals("logout")) {
            action = new LogoutAction();
        }else if(command.equals("cart_insert")) {
            action = null;
        }else if(command.equals("cart_list")) {
            action = null;
        }else if(command.equals("mypage")) {
            action = null;
        }else if(command.equals("qna_list")) {
            action = null;
        }

        return action;
    }
}
