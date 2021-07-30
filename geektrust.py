import sys
from train import Train

# main method defination
def main():
	
    try:
    	# sys.argv[1] should give the absolute path to the input file
    	# parse the file and process the command
    	input_file = sys.argv[1]
    	extension = input_file.split('.')
    	# checking file type
    	if extension[1] == 'txt':
    		# reading input file
    		with open(input_file) as f:
    			lines = f.readlines()
    		# Object instantiation
    		train = Train()
    		# calling arrival and departure station method
    		result = train.arrival_departure_station(lines)
    		# display arrival and departure station
    		for i in range(0,len(result),3):
    			print(result[i])
    			print(result[i+1])
    			print(result[i+2])
    	else:
    		print('Invalid input format')
    except Exception as e:
    	print(str(e))

if __name__ == "__main__":
    main()