package com.saeyan.controller;

import com.saeyan.controller.action.*;

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

        if(command.equals("board_list")) {
            action = new BoardListAction();
        }else if(command.equals("board_write_form")){
            action = new BoardWriteFormAction();
        }else if(command.equals("board_write")){
            action = new BoardWriteAction();
        }else if(command.equals("board_view")) {
            action = new BoardViewAction();
        }else if(command.equals("board_check_pass_form")) {
            action = new BoardCheckPassFormAction();
        }else if(command.equals("board_check_pass")) {
            action = new BoardCheckPassAction();
        }

        return action;
    }
}
