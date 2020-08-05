package com.hao.common.tools;

/**
 * @author jack hao
 * @createTime 2020-08-05-11:42
 */
public class DealwithQuestion {
    public static String dealwithOption(String options){
        String[] split_option = options.split("\", \"D\": \"|\", \"C\": \"|\", \"B\": \"");
        String optionA="<span class=\"op-item-nut\" style=\"margin-top: 0px;\">A . </span><span class=\"op-item-meat\" style=\"margin-top: 0px; white-space: normal;\">"+split_option[0].replace("{\"A\": \"","")+"</span>";
        String optionB="<span class=\"op-item-nut\" style=\"margin-top: 0px;\">B . </span><span class=\"op-item-meat\" style=\"margin-top: 0px; white-space: normal;\">"+split_option[1]+"</span>";
        String optionC="<span class=\"op-item-nut\" style=\"margin-top: 0px;\">C . </span><span class=\"op-item-meat\" style=\"margin-top: 0px; white-space: normal;\">"+split_option[2]+"</span>";
        String optionD="<span class=\"op-item-nut\" style=\"margin-top: 0px;\">D . </span><span class=\"op-item-meat\" style=\"margin-top: 0px; white-space: normal;\">"+split_option[3].replace("\"}","")+"</span>";

        //过滤掉一些干扰字符串
        String resOPtion=optionA+optionB+optionC+optionD;
        resOPtion = resOPtion.replace("u3000", "");

        return resOPtion;
    }

    public static String dealwithquestiontext(String question_text){
        String[] questions=question_text.split("==>");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(questions[0]);
        for (int i=1;i<questions.length;i++) {
            if(i != questions.length){
                stringBuffer.append("("+i+")"+questions[i]+"<br/>");
            }else{
                stringBuffer.append("("+i+")"+questions[i]);
            }

        }
        return stringBuffer.toString();
    }


    public static String dealwithanser(String answer){
        StringBuffer new_answer=new StringBuffer();
        if(answer.contains("==>")){
            String[] imgs=answer.split("==>");
            for (String an:imgs) {
                new_answer.append("<img src="+an+">");
            }
        }else{
            new_answer.append("<img src="+answer+">");
        }
        return new_answer.toString();
    }
}
