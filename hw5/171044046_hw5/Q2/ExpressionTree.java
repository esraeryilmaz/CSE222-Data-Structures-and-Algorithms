import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * ExpressionTree class
 *
 * @author Esra Eryılmaz
 * @since 2020-04-30
 */

public class ExpressionTree<E> extends BinaryTree<E>
{
	/**
	 * Constructor
	 * It calls readBinaryTree() method and that method construct binary expression tree.
	 */
	public ExpressionTree(String expression)
	{
		super();
		String[] exp2 = expression.split(" ");

		try {
			root = (Node<E>) readBinaryTree(expression,exp2,expression);
		}
		catch(Exception exception)
		{
			System.out.println("Exception");
		}
	}


	/**
	 * In BinaryTree class this method is static so I could not override it.
	 * Also I change BufferedReader to String.
	 * I use third parameter to decide expression is prefix or postfix
	 * @param expPre
	 * @param expPost
	 * @param e
	 * @return
	 * @throws IOException
	 */
	public Node<String> readBinaryTree(String expPre, String[] expPost, String e) throws IOException
	{
		if(!Character.isDigit(e.charAt(0)))		// If exp Prefix
		{
			String[] newExp1 = expPre.split(" ",2);
	
			if(newExp1[0].chars().allMatch(Character::isDigit))
			{
				return new Node<String>(newExp1[0]);
			}
			else
			{
				Node<String> n = new Node<String>(newExp1[0]);
	
				expPre = newExp1[1];
				n.left = readBinaryTree(expPre, null, e);
	
				String[] newExp2 = expPre.split(" ",2);
				expPre = newExp2[1];
				n.right = readBinaryTree(expPre, null ,e);
	
				return n;
			}
		}

		else		// If exp Postfix
		{
			if(expPost[expPost.length-1].chars().allMatch(Character::isDigit))
			{
				return new Node<String>(expPost[expPost.length-1]);
			}
			else
			{
				Node<String> n = new Node<String>(expPost[expPost.length-1]);
	
				expPost = Arrays.copyOf(expPost, expPost.length-1);
				n.right = readBinaryTree(expPre, expPost, e);
	
				expPost = Arrays.copyOf(expPost, expPost.length-1);
				n.left = readBinaryTree(expPre, expPost, e);
	
				return n;
			}
		}
	}


	/**
	 * Print its nodes according to the postorder traversal. 
	 * @param node
	 */
	protected void postOrderTraverse(Node<E> node)
	{
		if (node == null)
			return ;

		// first recur on left subtree 
		postOrderTraverse(node.left); 
  
		// then recur on right subtree 
		postOrderTraverse(node.right); 

		System.out.print(node.data + " ");
	}

	/**
	 * It calls postOrderTraverse() and prints expression in post order.
	 * @return
	 */
	public String toString2()
	{
		postOrderTraverse(root);
		return null;
	}

	/**
	 * To able to call eval(Node) method
	 * @return root node
	 */
	public Node<E> getRoot()
	{
		return this.root;
	}

	/**
	 * It evaluates the expression and returns the result.
	 * @param n
	 * @return result
	 */
	public int eval(Node<E>n)
	{
		int result, operand1, operand2;
		Node<E> temp;

		if (n==null)
			result = 0;
		else
		{
			temp = n;

			if (!Character.isDigit(((String) temp.data).charAt(0)))
			{
				operand1 = eval(n.left);
				operand2 = eval(n.right);
				char c = ((String) temp.data).charAt(0);
				result = compute(c, operand1, operand2);
			}
			else
				result = Integer.parseInt((String) temp.data);
		}
		return result;
	}

	/**
	 * It does math operations.
	 * @param operator
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private int compute(char operator, int operand1, int operand2)
	{
		int result=0;

		if(operator == '+')
			result = operand1 + operand2;
		else if(operator == '-')
			result = operand1 - operand2;
		else if(operator == '*')
			result = operand1 * operand2;
		else
			result = operand1 / operand2;

		return result;
	}


}
