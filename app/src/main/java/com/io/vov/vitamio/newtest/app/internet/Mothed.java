package com.netease.nim.demo.internet;

/**
 * Created by ${zhangzz} on 2016/2/19.
 * 接口枚举
 */
public enum  Mothed {
    GetTopKnowledge("GetTopKnowledge"),GetExampaperDetail("GetExampaperDetail"),
    GetRandomGenerateTest("GetRandomGenerateTest"),GetSurveyDetail("GetSurveyDetail")
    ,GetWrongQuestionDetail("GetWrongQuestionDetail"),SubmitStudentAnswer("SubmitStudentAnswer")
    ,SubmitTestAnswer("SubmitTestAnswer"),SubmitSurvey("SubmitSurvey"),
    RemoveWrongQuestions("RemoveWrongQuestions"),GetQuestionSorts("GetQuestionSorts")
    ,GetSurveyResult("GetSurveyResult"),SubmitExerciseStudentAnswer("SubmitExerciseStudentAnswer"),
    GetExamResultDetail("GetExamResultDetail"),EndExamExercise("EndExamExercise");

    private String name;

    Mothed(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
