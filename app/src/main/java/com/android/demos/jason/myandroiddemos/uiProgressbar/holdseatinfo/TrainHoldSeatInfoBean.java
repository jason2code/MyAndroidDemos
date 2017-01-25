package com.android.demos.jason.myandroiddemos.uiProgressbar.holdseatinfo;

import java.util.List;

/**
 * Created by xude1 on 17/1/12.
 */
//todo xude 所有下划线形式都要改写成驼峰形式
public class TrainHoldSeatInfoBean {
    /**
     * timeout_duration : 30
     * polling_duration : 30
     * holdseat_start_time : 1471316293000
     * server_current_time : 1471316334000
     * pay_limit_time : 2016-06-28 14:50
     * agent_name : 美团
     * start_time : 2016-05-28 13:40
     * arrive_time : 2016-05-28 13:59
     * run_time_minute : 00:09
     * run_time : 9
     * train_code : 6021
     * from_station_name : 孙家
     * from_station_telecode : SUB
     * to_station_name : 香坊
     * to_station_telecode : XFB
     * order_status_code : 60
     * order_status_name : 占座中
     * total_price : 5.0
     * insurance_cost_total : 10
     * tickets_insurance_total : 15
     * has_insurance : 1
     * is_promotion : 1
     * promotion_money : 1.00
     * paper_ticket_open : true
     * grab_ticket_open : true
     * is_12306_open : true
     * tickets : [{"booking_ticket_price":1,"coach_name":"","passenger_id_no":"612322198504244516","passenger_id_type_name":"身份证","passenger_name":"马俊","seat_name":"","seat_type_name":"硬座","ticket_type_name":"成人票"}]
     */
    public int timeout_duration;
    public int polling_duration;
    public long holdseat_start_time;
    public long server_current_time;
    public String pay_limit_time;
    public String agent_name;
    public String start_time;
    public String arrive_time;
    public String run_time_minute;
    public String run_time;
    public String train_code;
    public String from_station_name;
    public String from_station_telecode;
    public String to_station_name;
    public String to_station_telecode;
    public String order_status_code;
    public String order_status_name;
    public double total_price;
    public int insurance_cost_total;
    public int tickets_insurance_total;
    public int has_insurance;
    public int is_promotion;
    public String promotion_money;
    public boolean paper_ticket_open;
    public boolean grab_ticket_open;
    public boolean is_12306_open;
    public String book_12306_start_time; //12306启售时间	"06:00"
    public String book_12306_end_time;    //12306止售时间	"23:00"
    public int hold_seat_remain_time; //占座剩余时间（秒）	30
    public int pay_remain_time; //	支付剩余时间（秒）	30
    public double max_red_packets;     //	最大红包金额	5.00
    /**
     * booking_ticket_price : 1
     * coach_name :
     * passenger_id_no : 612322198504244516
     * passenger_id_type_name : 身份证
     * passenger_name : 马俊
     * seat_name :
     * seat_type_name : 硬座
     * ticket_type_name : 成人票
     */

    public List<TicketsBean> tickets;


    public static class TicketsBean {
        public int booking_ticket_price;
        public String coach_name;
        public String passenger_id_no;
        public String passenger_id_type_name;
        public String passenger_name;
        public String seat_name;
        public String seat_type_name;
        public String ticket_type_name;
    }
}
