from collections import deque 

class Node:

	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None

class BinaryTree:

	def __init__(self):
		self.root = None

	def insert(self, data):

		if self.root == None:
			node = Node(data)
			self.root = node
		else:
			queue = deque([])
			queue.append(self.root)
			while len(queue)!=0:
				temp = queue.popleft()

				if temp.left == None:
					node = Node(data)
					temp.left = node
					break
				elif temp.right == None:
					node = Node(data)
					temp.right = node
					break
				else:
					# if len(queue) == 0:
					queue.append(temp.left);
					queue.append(temp.right);

	def preOrder(self, root):

		if root == None:
			return
		print(root.data, end=" ")
		self.preOrder(root.left)
		self.preOrder(root.right)

	def disp(self):
		temp = self.root
		self.preOrder(temp)

if __name__ == "__main__":
	binaryTree = BinaryTree()
	n = int(input())
	for i in range(n):
		data = int(input())
		binaryTree.insert(data)
	binaryTree.disp()