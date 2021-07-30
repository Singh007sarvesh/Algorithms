# Import system module
import sys
# Import date class from datetime module
from datetime import datetime, date

class WorkSpace:

	# declaration of time slot c-cave,d-tower,g-mansion
	time_slot_c_cave = []
	time_slot_d_tower = []
	time_slot_g_mansion = []

	# defination of c cave book method
	def book_c_cave(self, start_time, end_time):
		# current_time = datetime.now()
		# start_interval_time = current_time.replace(hour=1,
		# 	minute=0, second=0, microsecond=0)
		# print(start_interval_time,start_time,end_time)
		if len(WorkSpace.time_slot_c_cave)==0:
			WorkSpace.time_slot_c_cave.append((start_time,end_time))
			return True
		else:
			flag = 0
			for time_slot in WorkSpace.time_slot_c_cave:
				if (start_time>=time_slot[0] and start_time>=time_slot[1]) or (
					start_time<=time_slot[0] and end_time<=time_slot[0]):
					flag = 1
				else:
					flag = 0
			if flag == 1:
				WorkSpace.time_slot_c_cave.append((start_time,end_time))
				return True
			return False

	# defination of d tower book method
	def book_d_tower(self, start_time, end_time):
		if len(WorkSpace.time_slot_d_tower)==0:
			WorkSpace.time_slot_d_tower.append((start_time,end_time))
			return True
		else:
			flag = 0
			for time_slot in WorkSpace.time_slot_d_tower:
				if (start_time>=time_slot[0] and start_time>=time_slot[1]) or (
					start_time<=time_slot[0] and end_time<=time_slot[0]):
					flag = 1
				else:
					flag = 0
			if flag == 1:
				WorkSpace.time_slot_d_tower.append((start_time,end_time))
				return True
			return False
	# defination of g mansion book method
	def book_g_mansion(self, start_time, end_time):
		if len(WorkSpace.time_slot_g_mansion)==0:
			WorkSpace.time_slot_g_mansion.append((start_time,end_time))
			return True
		else:
			flag = 0
			for time_slot in WorkSpace.time_slot_g_mansion:
				if (start_time>=time_slot[0] and start_time>=time_slot[1]) or (
					start_time<=time_slot[0] and end_time<=time_slot[0]):
					flag = 1
				else:
					flag = 0
			if flag == 1:
				WorkSpace.time_slot_g_mansion.append((start_time,end_time))
				return True
			return False

	# defination of buffer time for book
	def interval_time_slot_book(self, start_time, end_time):
		current_time = datetime.now()
		start_interval_time1 = current_time.replace(hour=9,
			minute=0, second=0, microsecond=0)
		end_interval_time1 = current_time.replace(hour=9,
			minute=15, second=0, microsecond=0)
		start_interval_time2 = current_time.replace(hour=13,
			minute=15, second=0, microsecond=0)
		end_interval_time2 = current_time.replace(hour=13,
			minute=45, second=0, microsecond=0)
		start_interval_time3 = current_time.replace(hour=18,
			minute=45, second=0, microsecond=0)
		end_interval_time3 = current_time.replace(hour=19,
			minute=0, second=0, microsecond=0)
		flag = 0
		# print(start_time.hour)
		if start_time.hour == 0 and start_time.minute == 0:
			 flag+=1
		if start_time>=end_interval_time1 and start_time>=start_interval_time1:
			flag += 1
		if (end_time<=end_interval_time2 and start_time<=start_interval_time2) or (
			start_time>=end_interval_time2 and start_time>=start_interval_time2):
			flag += 1
		if (end_time<=end_interval_time3 and start_time<=start_interval_time3) or (
			start_time>=end_interval_time3 and start_time>=start_interval_time3):
				flag += 1
		if flag == 3 or flag == 4:
			return True
		else:
			return False

	# defination of book meeting room at workspace
	def book_meeting_room(self, input_list):
		start_hour_minute = input_list[1].split(':')
		end_hour_minute = input_list[2].split(':')
		# booking can be started and ended only in 15 minute intervals
		if int(start_hour_minute[1])%15!=0 or int(end_hour_minute[1])%15!=0:
			return 'INCORRECT_INPUT'
		# returns current date and time
		current_time = datetime.now()
		start_time = current_time.replace(hour=int(start_hour_minute[0]),
			minute=int(start_hour_minute[1]), second=0, microsecond=0)
		end_time = current_time.replace(hour=int(end_hour_minute[0]),
			minute=int(end_hour_minute[1]), second=0, microsecond=0)
		person_capacity = int(input_list[3])
		if len(start_hour_minute)>2 or len(end_hour_minute)>2:
			return 'INCORRECT_INPUT'
		else:
			if end_time>start_time:
				# if int(start_hour_minute[0]) != 0 and int(start_hour_minute[1]) != 0:
				# calling buffer method of workspace class
				flag = self.interval_time_slot_book(start_time, end_time)
				if not flag:
					return 'NO_VACANT_ROOM'
				else:
					# print(person_capacity)
					if person_capacity<4:
						# book particular room 
						if self.book_c_cave(start_time, end_time):
							return 'C-Cave'
						elif self.book_d_tower(start_time, end_time):
							return 'D-Tower'
						elif self.book_g_mansion(start_time, end_time):
							return 'G-Mansion'
						else:
							return 'NO_VACANT_ROOM'
					elif person_capacity>3 and person_capacity<8:
						# book particular room 
						if self.book_d_tower(start_time, end_time):
							return 'D-Tower'
						elif self.book_g_mansion(start_time, end_time):
							return 'G-Mansion'
						else:
							return 'NO_VACANT_ROOM'
					elif person_capacity>7 and person_capacity<21:
						# book particular room 
						if self.book_g_mansion(start_time, end_time):
							return 'G-Mansion'
						else:
							return 'NO_VACANT_ROOM'
					else:
						return 'NO_VACANT_ROOM'
			else:
				return 'INCORRECT_INPUT'

	# defination of buffer time for view
	def interval_time_slot_view(self, start_time, end_time):
		current_time = datetime.now()
		start_interval_time1 = current_time.replace(hour=9,
			minute=0, second=0, microsecond=0)
		end_interval_time1 = current_time.replace(hour=9,
			minute=15, second=0, microsecond=0)
		start_interval_time2 = current_time.replace(hour=13,
			minute=15, second=0, microsecond=0)
		end_interval_time2 = current_time.replace(hour=13,
			minute=45, second=0, microsecond=0)
		start_interval_time3 = current_time.replace(hour=18,
			minute=45, second=0, microsecond=0)
		end_interval_time3 = current_time.replace(hour=19,
			minute=0, second=0, microsecond=0)
		flag = 0
		if start_time.hour == 0 and start_time.minute == 0:
			 flag+=1
		if start_time>end_interval_time1 and start_time>start_interval_time1:
			flag += 1
		if (end_time<end_interval_time2 and start_time<start_interval_time2) or (
			start_time>=end_interval_time2 and start_time>start_interval_time2):
			flag += 1
		if (end_time<end_interval_time3 and start_time<start_interval_time3) or (
			start_time>=end_interval_time3 and start_time>start_interval_time3):
				flag += 1
		if flag == 3 or flag == 4:
			return True
		else:
			return False

	# defination of view available room		
	def view_available_room(self, input_list):
		start_hour_minute = input_list[1].split(':')
		end_hour_minute = input_list[2].split(':')
		# returns current date and time
		current_time = datetime.now()
		start_time = current_time.replace(hour=int(start_hour_minute[0]),
			minute=int(start_hour_minute[1]), second=0, microsecond=0)
		end_time = current_time.replace(hour=int(end_hour_minute[0]),
			minute=int(end_hour_minute[1]), second=0, microsecond=0)
		# time_limit = current_time.replace(hour=23,
		# 	minute=45, second=0, microsecond=0)
		if end_time>start_time:
			flag = self.interval_time_slot_view(start_time, end_time)
			if not flag:
				return ['NO_VACANT_ROOM']
			else:
				available_room_list = []
				flag = 0
				# print(WorkSpace.time_slot_c_cave)
				for time_slot in WorkSpace.time_slot_c_cave:
					if start_time>=time_slot[0] and start_time<time_slot[1] or (
						start_time<time_slot[0] and end_time>=time_slot[1]):
						flag = 1
				if flag == 0:
					available_room_list.append('C-Cave')
				flag = 0
				for time_slot in WorkSpace.time_slot_d_tower:
					# print('d',time_slot)
					if (start_time>=time_slot[0] and start_time<time_slot[1]) or (
						start_time<time_slot[0] and end_time>=time_slot[1]):
						flag = 1
				if flag == 0:		
					available_room_list.append('D-Tower')
				flag = 0
				for time_slot in WorkSpace.time_slot_g_mansion:
					if (start_time>=time_slot[0] and start_time<time_slot[1]) or (
						start_time<time_slot[0] and end_time>=time_slot[1]):
						flag = 1
				if flag == 0:
					available_room_list.append('G-Mansion')
				return available_room_list
		else:
			return ['INCORRECT_INPUT']

# defination of main function
def main():
	
    # try:
    	# sys.argv[1] should give the absolute path end the input file
    	# parse the file and process the command
	input_file = sys.argv[1]
	extension = input_file.split('.')
	# checking file type
	if extension[1] == 'txt':
		# reading input file
		input_ = open(input_file,"r")
		# Object instantiation
		work_space = WorkSpace()
		for i in input_:
			input_list = i.split(' ')
			input_list[len(input_list)-1] = input_list[
			len(input_list)-1].replace('\n','')
			if input_list[0] == 'VACANCY':
				# calling view available room method
				available_room = work_space.view_available_room(input_list)
				if len(available_room) == 0:
					print('NO_VACANT_ROOM')
				else:
					print(" ".join(available_room))
			elif input_list[0] == 'BOOK':
				# calling book meeting room method
				print(work_space.book_meeting_room(input_list))
			else:
				print('Invalid input format')
		
	else:
		print('Invalid input format')
    # except Exception as e:
    # 	print(str(e))

if __name__ == "__main__":
	# calling main function
    main()