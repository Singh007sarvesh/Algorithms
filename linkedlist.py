class Node:

	def __init__(self, data):
		self.data = data
		self.next = None


class LinkedList:

	def __init__(self):
		self.head = None
		self.temp = self.head

	def insert(self, data):
		if self.head == None:
			self.head = Node(data)
			self.temp = self.head;
		else:
			node = Node(data)
			self.temp.next = node
			self.temp = node
	
	def insertAtPosition(self, data, pos):
		temp = self.head
		prev = None
		for i in range(0,pos):
			prev = temp
			temp = temp.next
			if temp.next == None:
				break
		node = Node(data)
		if pos <= 0:
			node.next = temp
			self.head = node
		elif temp.next == None:
			temp.next = node
		else:
			node.next = temp
			prev.next = node

	def reverse(self):
		prev = None
		cur = self.head;
		while cur!=None:
			temp = cur.next; 
			cur.next = prev;
			prev = cur
			cur = temp
		self.head = prev


	def delete(self, data):
		temp = self.head
		prev = None
		cur = None		
		if temp.data == data:
			self.head = temp.next
			temp.next == None
		elif temp.next == None:
			self.head = None
			return
		else:
			while(temp!=None):
				if temp.data == data:
					cur = temp.next
					temp.next = None
					temp = None
					break
				else:
					prev = temp
				temp = temp.next
			if cur == None:
				prev.next = None
			else:
				prev.next = cur

	def disp(self):
		self.temp = self.head
		if self.head == None:
			return
		while(self.temp!=None):
			print(self.temp.data)
			self.temp = self.temp.next

if __name__ == '__main__':
	linkedList = LinkedList()
	n  = int(input())
	for i in range(0,n):
		data = int(input())
		linkedList.insert(data)
	pos = int(input())
	data = int(input())
	linkedList.insertAtPosition(data, pos)
	linkedList.disp()
	deletedata = int(input())
	linkedList.delete(deletedata)
	print("after delete")
	linkedList.reverse()
	linkedList.disp()