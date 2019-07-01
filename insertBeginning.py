class Node:
	def __init__(self, data):
		self.data = data
		self.next = None


class LinkedList:
	def __init__(self):
		self.head = None

	def insert(self, data):
		node = Node(data)
		if self.head == None:
			self.head = node
		else:
			node.next = self.head
			self.head = node 

	def disp(self):
		temp = self.head
		while temp!=None:
			print(temp.data, end=' ')
			print()
			temp = temp.next
		


if __name__ == '__main__':

	n = int(input())
	linkedList = LinkedList()
	for i in range(0, n):
		data = int(input())
		linkedList.insert(data)
	linkedList.disp()