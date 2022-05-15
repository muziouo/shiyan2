package com.muzi.struct_cal;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        CalActionForm calForm = (CalActionForm) form;

        int value1 = calForm.getValue1();
        String flag = calForm.getFlag();
        int value2 = calForm.getValue2();

        int result = 0;


        try {
            if ("+".equals(flag)) {
                result = value1 + value2;
            } else if ("-".equals(flag)) {
                result = value1 - value2;
            } else if ("*".equals(flag)) {
                result = value1 * value2;
            } else if ("/".equals(flag)) {
                result = value1 / value2;
            }
            request.setAttribute("result", result);
            return mapping.findForward("success");
        } catch (Exception e) {
            e.printStackTrace();
            mapping.findForward("error");

        }
        return mapping.findForward("error");
    }
}