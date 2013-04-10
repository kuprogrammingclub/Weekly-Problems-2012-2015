import sys
import re
print(''.join(re.findall(r"[a-zA-Z]", ''.join(sys.stdin.readlines())))) 
