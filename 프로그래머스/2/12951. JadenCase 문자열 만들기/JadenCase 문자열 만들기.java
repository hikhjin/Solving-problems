class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true; // 다음 문자를 대문자로 변환할지 여부

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append(ch);
                capitalizeNext = true; // 공백 이후의 첫 문자는 대문자로 변환
            } else {
                if (capitalizeNext) {
                    sb.append(Character.toUpperCase(ch));
                    capitalizeNext = false;
                } else {
                    sb.append(Character.toLowerCase(ch));
                }
            }
        }

        return sb.toString();
    }
}
