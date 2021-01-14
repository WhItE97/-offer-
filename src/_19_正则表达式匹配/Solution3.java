package _19_������ʽƥ��;

public class Solution3 {
	/**
	 * dp
	 * f[i][j]=s��ǰi���ַ���p��ǰj���ַ�ƥ���boolean
	 * ���壺i��j��0->��ÿ��f[x][y]��Ӧ���������Ӻ���ǰmatch
	 * base��f[0][0]=true
	 * ˼·��
	 * 1.'.'�ȽϺô���ֻ��matchʱ��������
	 * 2.'*'����ÿһ�֣������ַ����Ӻ���ǰmatch��ʱ��'ch*'(p[j]='*')�޷Ǿ�2�������
	 * 	��1��'ch*'ֱ��ȫɾȥ����������ȡmatch->f[i][j] = f[i][j-2]
	 * 	��2��'ch*'����ȥmatch
	 * 		��s[i]��p[j-1]match(����s[i]��ch*��ϼ�����s��ǰһλmatch):f[i][j] = f[i-1][j]
	 * 		��s[i]��p[j-1]��match(����ch*��ϣ�s[i]������p��ǰһλmatch):f[i][j] = f[i][j-2]
	 * ת�Ʒ��̣�
	 * f[i][j]=
	 * 1.p[j]!='*'
	 * 	1)matches(s[i],p[j]):f[i][j] = f[i-1][j-1]
	 * 	2)no match:f[i][j] = false
	 * 2.p[j]=='*'
	 * 	1)ֱ�Ӷ���ch*���:f[i][j] = f[i][j-2]
	 * 	2)��matches(s[i],p[j-1]):f[i][j] = f[i-1][j]
	 * 	  ��no match:f[i][j] = f[i][j-2]
	 */
	public boolean isMatch(String s,String p) {
		boolean[][] f = new boolean[s.length()+1][p.length()+1];//��Ϊ�п��ַ�����base:f[0][0]������dp����Ҫ��length������+1
		f[0][0] = true;
		for(int i=0;i<=s.length();i++) {
			/**��ϸ��1��
			 * i���Դ�0��ʼ��Ϊ��s�����÷ǿ�p�ɹ�ƥ�䣡��s="",p="a*"->f[0][>0](f[0][0]��base����ǰд��true)
			 * ���ǲ���s�ǿգ�ȴ�ÿյ�p�ɹ�ƥ�䣡->f[>0][>0]
			 */
			for(int j=1;j<=p.length();j++) {
				//1.p[j]!='*'
				/**��ϸ��2��
				 * ����j��p.length()->1����Ӧ�ַ���p�ĵ�p.length()���ַ�����1���ַ�����ʵ���ڴ��е��±�=(p.length()-1)->0��
				 * ����������ַ���������в�����ʱ��jҪ-1
				 * ��������matches()��ȴ�������i��j��
				 * ����Ϊi��j��ͳһ�ˣ�������i��jָ�������ַ�����i���͵�j���ַ�����Ӧ�����±궼��(i-1)��(j-1)�����ĺ���
				 * ����matches��ʱ�򣬴���ġ�s��ǰi������i�͡�p��ǰj������j����һ�º��壡
				 * ��i��j�漰��ȡ�ַ����е�λ�õ�ʱ�򣬶�����-1�������ɣ������ｻ��matches�ˣ���matchesע�ͣ�
				 */
				if(p.charAt(j-1)!='*') {
					//1.1.matches(s[i],p[j])->f[i][j] = f[i-1][j-1]
					if(matches(s,p,i,j)) {
						f[i][j] = f[i-1][j-1];
					}
					else {//1.2.no match:false
						f[i][j] = false;
					}
				}
				//2.p[j]=='*'
				else {
					/**
					 * �����׿��Ƕ���һ�㣡��������ȥ����match��ֱ�Ӷ���ch*��ϣ�������
					 */
					//2.1.ֱ�Ӷ���ch*
					f[i][j] = f[i][j-2];
					//2.2.1.matches(s[i],p[j-1])->����s[i]��ch*������s��ǰ��ƥ�䣻����ǰ��f[i][j]����Ϊ�棬����Ҫȡ��
					if(matches(s,p,i,j-1)) {
						f[i][j] = f[i][j]||f[i-1][j];
					}
					//2.2.2.no match->����ch*��f[i][j] = f[i][j-2]������2.1.�Ѿ������˶�����������������ﲻ���ٴ����ˣ���
				}
			}
		}
		return f[s.length()][p.length()];
	}
	//matches����ı����ǱȽ�i��j��Ӧ����s�ĵ�i����p�ĵ�j������i���͵�j����ʵ���ַ���Ҫ-1�ģ����ַ�����0��ʼ����ַ�����
	public boolean matches(String s,String p,int i,int j) {
		if(i==0) {//��Ϊi��0��ʼѭ���ģ�����Ҫ����i����-1��ȡ�±��ˣ�
			return false;
		}
		if(p.charAt(j-1)=='.') {
			return true;
		}
		return s.charAt(i-1)==p.charAt(j-1);
	}
}
