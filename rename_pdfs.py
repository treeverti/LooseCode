import os

directory_path = ''
new_directory_path = ''

for filename in os.listdir(directory_path):
	new_filename = filename.replace("DCW_", "PX").replace("_finalized", "")
	new_file_path = os.path.join(new_directory_path, new_filename)
	os.rename(os.path.join(directory_path, filename), new_file_path)
	print(f'Renamed "{filename}" to "{new_filename}"')