package bohum.test;

/* Java 1.8 ���� �ڵ� */

// json���� ���� �� ��..!!!!!!!!!!!!!!!!!!1
// �ѱ� ���� ���� �ذ�����
// json ���� �ٷ���??
// �׷��� ������ �Ľ��� �Ǿ��!!!!!!!!!!!!!!!!!!!!!!
// �����������������Ŀ������Ĥ� 


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

public class BohumTest03_01 {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1160100/service/GetMedicalReimbursementInsuranceInfoService/getInsuranceInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=wKQumq5LX0aGJN19E3mLdne0GDiEtPtVpVY3tDVBkOYPc21sBxDu%2B4lUggPaO0ETQboYKIVcYuGsd5lxtqhYoQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")); /*�� ������ ��� ��*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*������ ��ȣ*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*�������(xml/json)*/
        urlBuilder.append("&" + URLEncoder.encode("age","UTF-8") + "=" + URLEncoder.encode("27", "UTF-8")); /*����*/       
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        String myData = sb.toString();
        JSONParser parser = new JSONParser();
        try {
        	JSONObject obj = (JSONObject)parser.parse(myData);

        	JSONObject jsonObj = (JSONObject)obj;
        	JSONObject jsonResponse = (JSONObject)jsonObj.get("response");
        	JSONObject jsonBody = (JSONObject)jsonResponse.get("body");
        	JSONObject jsonItems = (JSONObject)jsonBody.get("items");
        	JSONArray jsonItem = (JSONArray)jsonItems.get("item");
        	for(int i=0;i<jsonItem.size();i++) {
        		JSONObject item = (JSONObject)jsonItem.get(i);
        		System.out.println("basDt : "+item.get("basDt"));//YYYYMMDD ��������
        		System.out.println("cmpyCd : "+item.get("cmpyCd"));// ȸ���ڵ�
        		System.out.println("cmpyNm : "+item.get("cmpyNm"));// ȸ���
        		System.out.println("ptrn : "+item.get("ptrn"));//	����
        		System.out.println("mog : "+item.get("mog"));// �㺸
        		System.out.println("prdNm : "+item.get("prdNm"));// ��ǰ��
        		System.out.println("age : "+item.get("age"));// ����
        		System.out.println("mlInsRt : "+item.get("mlInsRt"));// ���ں����
        		System.out.println("fmlInsRt : "+item.get("fmlInsRt"));// ���ں����
        	}

        } catch (ParseException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }

        
    }
}
