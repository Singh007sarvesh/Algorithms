import sys


class Train:
	
	# station code and corresponding distance
	station_distance = {'HYB':1200,'NGP':1600,'ITJ':1900,'BPL':2000,'AGA':2500,
	'NDL':2700,'PTA':3800, 'NJP':4200,'GHY':4700}


	def reach_at_arrival_departure(self, station_code, 
		arrival_station_list, departure_bogie):
		# checking station code for arrival and departure station
		if station_code == 'HYB':
			arrival_station_list.append(station_code)
		elif station_code == 'NGP':
			arrival_station_list.append(station_code)
			departure_bogie.append(
				(station_code,Train.station_distance[station_code]))
		elif station_code == 'ITJ':
			arrival_station_list.append(station_code)
			departure_bogie.append(
				(station_code,Train.station_distance[station_code]))
		elif station_code == 'BPL':
			arrival_station_list.append(station_code)
			departure_bogie.append(
				(station_code,Train.station_distance[station_code]))
		elif station_code == 'AGA':
			arrival_station_list.append(station_code)
			departure_bogie.append(
				(station_code,Train.station_distance[station_code]))
		elif station_code == 'NDL':
			arrival_station_list.append(station_code)
			departure_bogie.append(
				(station_code,Train.station_distance[station_code]))
		elif station_code == 'PTA':
			arrival_station_list.append(station_code)
			departure_bogie.append(
				(station_code,Train.station_distance[station_code]))
		elif station_code == 'NJP':
			arrival_station_list.append(station_code)
			departure_bogie.append(
				(station_code,Train.station_distance[station_code]))
		elif station_code == 'GHY':
			arrival_station_list.append(station_code)
			departure_bogie.append(
				(station_code,Train.station_distance[station_code]))

	# sorting station code based on distance in descending order
	def sort_by_distance(self, departure_bogie):
		return sorted(departure_bogie, key = lambda bogie: bogie[1], reverse =True)

	# find arrival and departure station
	def arrival_departure_station(self, lines):
		departure_bogie = []
		arrival_departure_train = []
		# reading input from list
		for ln in lines:
			station_code_list = ln.split(' ')
			arrival_station_list = []
			station_code_list[len(station_code_list)-1] = station_code_list[len(station_code_list)-1].replace('\n','')
			# iterating station code from station code list
			for station_code in station_code_list:
				# calling method
				self.reach_at_arrival_departure(station_code, arrival_station_list, departure_bogie)
			# add arrival station of train A and B
			arrival_departure_train.append('ARRIVAL ' + station_code_list[0] + ' ENGINE ' + ' '.join(arrival_station_list))
    	# sorting station name based on distance
		departure_bogie = self.sort_by_distance(departure_bogie)
		station_code = ''
		for db in departure_bogie:
			station_code +=db[0]+' '
		# add departure station of train AB
		arrival_departure_train.append(
			'DEPARTURE TRAIN_AB ENGINE ENGINE '+ station_code)
		return arrival_departure_train