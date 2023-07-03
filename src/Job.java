package org.example;

public class Job {

    public String job;

    public float income;

    public int industryid;


    public Job(String title, float income, int industryid) {
        this.job = title;
        this.income = income;
        this.industryid = industryid;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String title) {
        this.job = title;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public int getIndustryid() {
        return industryid;
    }

    public void setIndustryid(int industryid) {
        this.industryid = industryid;
    }

}
