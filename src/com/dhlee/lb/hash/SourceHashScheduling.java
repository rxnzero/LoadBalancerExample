package com.dhlee.lb.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class SourceHashScheduling {

    private static final int SERVER_COUNT = 3; // 서버 수
    private static List<String> serverList = new ArrayList<>();

    static {
        // 실제 서버의 IP 또는 호스트 이름을 여기에 추가
        serverList.add("Server1");
        serverList.add("Server2");
        serverList.add("Server3");
    }

    public static String getServerForClient(String clientIP) {
        int hashCode = calculateHashCode(clientIP);
        int serverIndex = Math.abs(hashCode) % SERVER_COUNT;
        return serverList.get(serverIndex);
    }

    private static int calculateHashCode(String input) {
        CRC32 crc32 = new CRC32();
        crc32.update(input.getBytes());
        return (int) crc32.getValue();
    }
    
    private static void testHash(String clientIP) {
    	// 클라이언트 IP를 기반으로 서버 선택
        String selectedServer = getServerForClient(clientIP);

        // 선택된 서버 출력
        System.out.println("Client IP: " + clientIP);
        System.out.println("Selected Server: " + selectedServer);
    }
    public static void main(String[] args) {
        // 예제 클라이언트 IP
        String clientIP = "192.168.1.1";
        testHash(clientIP);
        
        clientIP = "192.168.1.2";
        testHash(clientIP);
        
        clientIP = "192.168.1.3";
        testHash(clientIP);
        
        clientIP = "192.168.1.4";
        testHash(clientIP);
        
        clientIP = "192.168.1.4";
        testHash(clientIP);
        
    }
}
