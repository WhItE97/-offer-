package _32_3_从上到下打印二叉树3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
	/**
	 * BFS的队列实现（从上到下，每一行从左到右）
	 * 记录：1.当前行剩余待打印节点数2.下一行总共需要打印的节点数 的同时！
	 * ->记录行数，每到奇数行，就先压栈出栈->再把出栈后的元素序列add进list
	 */
	public List<List<Integer>> levelOrder(TreeNode root){
		//base
		if(root==null) {
			return (new ArrayList<>());
		}
		//1.设置两个记录指针 以及extra！新的 行数指针level！
		int waitnodes = 1;//root非空，所以开始=1
		int nextsum = 0;
		int level = 0;//当前root为第0行->偶数行从左到右，奇数行从右到左打印
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<List<Integer>> res = new LinkedList<>();
		List<Integer> route = new ArrayList<>();
		q.add(root);
		//2.开始进行出入队操作
		while(!q.isEmpty()||route.size()!=0) {
			if(waitnodes==0) {//【结束一行的判定！！！】如果本行结束->根据level来判断1.直接add进res还是2.
				if((level&1)==0) {//偶数层，直接把子list add进res
					res.add(new ArrayList<Integer>(route));
				}
				else {//奇数层，需要先把子list反序（for遍历取反or栈都行），再把该子list add进res
					List<Integer> tmp = new ArrayList<>();
					for(int i=route.size()-1;i>=0;i--) {
						tmp.add(route.get(i));//反序子list
					}
//					System.out.println("反序后："+tmp.toString());
					res.add(new ArrayList<Integer>(tmp));
				}
				route.clear();//处理完一行后清空route，进入下一行的遍历
				level++;//处理完一行则行数记录+1
				waitnodes = nextsum;
				nextsum = 0;
//				System.out.println("level="+level+",waitnodes="+waitnodes);
				continue;
			}
			TreeNode tmp = q.remove();//正常出入队
			route.add(tmp.val);
			waitnodes--;
//			System.out.println("route now:"+route.toString()+",waitnodes now="+waitnodes);
			if(tmp.left!=null) {
				q.add(tmp.left);
				nextsum++;
			}
			if(tmp.right!=null) {
				q.add(tmp.right);
				nextsum++;
			}
		}
		return res;
	}
}
