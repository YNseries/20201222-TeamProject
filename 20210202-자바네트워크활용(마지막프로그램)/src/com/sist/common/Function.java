package com.sist.common;
// 내부 프로토콜 (약속 => 서버와 클라이언트)
// 웹 => 파일명 
public class Function {
   public static final int LOGIN=100;  // 먼저 로그인 한 사람
   public static final int MYLOG=110;  // 로그인 하는 사람
   public static final int SENDMESSAGE=200;
   public static final int CHAT=300;
   // 종료
   public static final int EXIT=400;   // 남아있는 사람(누가 나갔다고 알려줘야..)
   public static final int MYEXIT=410; // 실제 나가는 사람.  항상 두 개씩 처리해야 함
}