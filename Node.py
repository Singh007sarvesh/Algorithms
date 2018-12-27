class Node:
	def __init__(self,data):
		self.data = data
		self.next = None


class linked_list:
	def __init__(self):
		self.head = None
		self.prev = None
	def disp(self):
		if self.head == None:
			return
		temp = self.head
		while temp!=None:
			print(temp.data,end=" ")
			temp = temp.next
	def insert(self,data):
		if self.head == None:
			node = Node(data)
			self.head = node
			self.prev = node
		else:
			node = Node(data)
			self.prev.next = node
			self.prev = node
	def insert_at_begning(self, data):
		if self.head == None:
			node = Node(data)
			self.head = node
		else:
			node = Node(data)
			node.next = self.head
			self.head = node
	def delete_node(self, pos):
		temp = self.head
		pre = None
		right = None
		c = 0
		while temp!=None:
			c = c + 1
			if c == pos:
				pre = temp.next
				break;
			else:
				right = temp
			temp = temp.next
		right.next = pre
if __name__ == '__main__':
	linkedlist = linked_list()
	n = int(input())
	for i in range(n):
		data = int(input())
		linkedlist.insert(data)
	linkedlist.disp()
	data = int(input())
	print()
	linkedlist.delete_node(data)
	print()
	linkedlist.disp()
		
		
