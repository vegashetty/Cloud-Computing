import time
import requests;


def executeSomething():
    #code here
	for i in range(10000):
		v = requests.get("https://www.ultronbankapp.net/CloudProject-3");
		t = requests.get("https://www.ultronbankapp.net/CloudProject-3");
		s = requests.get("https://www.ultronbankapp.net/CloudProject-3");
		r = requests.get("https://www.ultronbankapp.net/CloudProject-3");
		p = requests.get("https://www.ultronbankapp.net/CloudProject-3");
		print (r.content);
		print (p.content);
		print (v.content);
		print (s.content);
		print (t.content);
		r.raw.read()
		assert(r.status_code == 200), 'not 200'
		assert(p.status_code == 200), 'not 200'
#	time.sleep(1)

while True:
    executeSomething()