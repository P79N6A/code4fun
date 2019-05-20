//package com.batter.code4fun.rocket;
//
//import com.alibaba.fastjson.JSONObject;
//import com.bytedance.Util.FileWriteUtil;
//import com.bytedance.Util.HttpServiceImpl;
//import com.bytedance.Util.FileReaderUtil;
//import com.redis.S;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//public class RedPacketStressTest {
//    public void generateToken() {
//        try {
//            List<String> listSession = FileReaderUtil.readFile2List(System.getProperty("user.dir") + "/src/main/resources/data/1394_session_0507_tag.csv");
//            int index = (int) (Math.random() * listSession.size());
//            String currentSession1 = listSession.get(index);
////            String sessionid = currentSession1.split(",")[1];
//            String sessionid = "7c34560438391432fdf5b31ef428c752";
//            System.out.println(sessionid);
////            String uid = currentSession1.split(",")[0];
//            String uid = "1617941534620695";
//            Map<String, String> jsonMap = new HashMap<>();
//            jsonMap.put("Content-Type", "application/json");
//            jsonMap.put("Accept", "application/json");
//            jsonMap.put("X-Tt-Stress", "test");
//            jsonMap.put("Cookie", "sessionid=" + sessionid);
//
//            int max1 = 400000000;
//            int min1 = 300000000;
//            Random random1 = new Random();
//            int s = random1.nextInt(max1) % (max1 - min1 + 1) + min1; //[min,max]之间取值
//
//            int max2 = 500000000;
//            int min2 = 400000000;
//            Random random2 = new Random();
//            int c = random2.nextInt(max2) % (max2 - min2 + 1) + min2; //[min,max]之间取值
//
//            //创建线下kol测试红包新url
//            String url1 = "http://10.8.124.189:3438/temp_rp_admin/kol_plus/create/v1/?Token=" + String.valueOf(s) + "&ExpireHours=72&AffiliationID=50321078&AffiliationType=2";
//            //创建线下kol测试红包老url
////            String urlo1 = "http://10.8.124.189:3438/temp_rp_admin/kol/create/v1/?ID="+String.valueOf(c)+"&Owner=1617941534620695&Token="+String.valueOf(c)+"&Amount=3&Num=1&Longitude=116.3285422325&Latitude=39.9722198977&Radius=999&LabelType=5&ExpireHours=72&t=87fd6069c1e6b2ff0273e77d2ab9261a";
//            String url2 = "http://10.8.124.189:3438/rp/kol/search/v1/?aid=1394&iid=71099755012&aid=1394&os_version=12.2&app_name=flipchat&channel=local_test&idfa=130F3945-8375-4FF7-BFF4-7E5E768A04AD&device_platform=iphone&fl_update_version_name=1.2.3.18&vid=4737617D-9F91-4E7C-969D-D4AEC86563F5&openudid=774823688a840693c9fdbda3b370be4eee326211&device_type=iPhone%207%20Plus&update_version_name=12318&idfv=4737617D-9F91-4E7C-969D-D4AEC86563F5&device_id=59619772404&ac=WIFI&install_id=71099755012&version_code=1.2.3&resolution=1242*2208&mas=0119466fbb5c8ad6309cf71e9ab4a83e0763ba43b68dc4ba7d5eb1&as=a22507cdf12b5c06e10709&ts=1557231281";
//            String url3 = "http://10.8.124.189:3438/rp/kol/open/v1/?aid=1394&iid=71099755012&aid=1394&os_version=12.2&app_name=flipchat&channel=local_test&idfa=130F3945-8375-4FF7-BFF4-7E5E768A04AD&device_platform=iphone&fl_update_version_name=1.2.3.18&vid=4737617D-9F91-4E7C-969D-D4AEC86563F5&openudid=774823688a840693c9fdbda3b370be4eee326211&device_type=iPhone%207%20Plus&update_version_name=12318&idfv=4737617D-9F91-4E7C-969D-D4AEC86563F5&device_id=59619772404&ac=WIFI&install_id=71099755012&version_code=1.2.3&resolution=1242*2208&mas=0119466fbb5c8ad6309cf71e9ab4a83e0763ba43b68dc4ba7d5eb1&as=a22507cdf12b5c06e10709&ts=1557231281";
//
//            //create新口令红包
//            String resp1 = HttpServiceImpl.httpGet(url1, jsonMap);
//            System.out.println("创建新口令红包 => " + resp1);
//            //create旧口令红包
////            String respo1 = HttpServiceImpl.httpGet(urlo1, jsonMap);
////            System.out.println("respo1 => " + respo1);
//            //search新口令红包
//            String jsonObj2 = "{\"token\":\"" + String.valueOf(s) + "!" + "\"}";
//            System.out.println("token:"+jsonObj2);
//            String resp2 = HttpServiceImpl.httpPostForJson(url2, jsonObj2, jsonMap);
//            System.out.println("搜索口令红包 => " + resp2);
//            Long orderid = JSONObject.parseObject(resp2).getJSONObject("info").getLong("order_id");
//            String tokens = ((JSONObject) JSONObject.parse(resp2)).get("token").toString();
//            //open新口令红包
//            String jsonObj3 = "{\"action\":1}";
//            System.out.println(jsonObj3);
//            JSONObject jsonObject3 = JSONObject.parseObject(jsonObj3);
//            jsonObject3.put("order_id", orderid);
//            jsonObject3.put("token", tokens);
//            System.out.println();
//            String resp3 = HttpServiceImpl.httpPostForJson(url3, jsonObject3.toString(), jsonMap);
//            System.out.println("打开口令红 => " + resp3);
//
//
//
//
////            String tokens = ((JSONObject) JSONObject.parse(resp2)).get("token").toString();
////            String orderid = ((JSONObject) ((JSONObject) JSONObject.parse(resp2)).get("info")).get("order_id").toString();
////            String cj_order_id = ((JSONObject) ((JSONObject) JSONObject.parse(resp1)).get("info")).get("cj_order_id").toString();
//            System.out.println(tokens);
//            System.out.println(orderid);
//            FileWriteUtil.writeFile(sessionid + "," + tokens + "," + orderid, System.getProperty("user.dir") + "/src/main/resources/data/kol_token_orderId_offline.csv");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        new CreateWithSearch().generateToken();
//    }
//}