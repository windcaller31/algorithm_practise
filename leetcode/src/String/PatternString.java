package String;

public class PatternString {
	public static void main(String args[]) {
//		String s = "aa";
//		String p = "*.";
		String s = "mississippi";
		String p = "mis*is*p*.";
		System.out.print(isMatch(s, p));
	}

	private static boolean matched = false;

	public static boolean isMatch(String s, String p) {
		char[] text = s.toCharArray();
		char[] pattern = p.toCharArray();
		rmatch(0, 0, text, text.length, pattern);
		return matched;
	}

	public static void rmatch(int ti, int pj, char[] text, int tlen, char[] pattern) {
		if (matched) {
			return;
		}
		if (pj == pattern.length) {
			if (ti == tlen) {
				matched = true;
			}
			return;
		}
		if (pattern[pj] == '*') {// 匹配多个
			for (int k = 0; k <= tlen - ti; k++) {
				rmatch(ti + k, pj + 1, text, tlen, pattern);
			}
		} else if (pattern[pj] == '.') {// 匹配一个或者零个
			rmatch(ti + 1, pj + 1, text, tlen, pattern);
			rmatch(ti, pj + 1, text, tlen, pattern);
		} else if (ti < tlen && pattern[pj] == text[ti]) {
			rmatch(ti + 1, pj + 1, text, tlen, pattern);
		}
	}
}
