import requests
import mysql.connector
import http.client
import urllib
import ssl
import json
#ssl._create_default_https_context = ssl._create_unverified_context

#-------
# Open database connection
db= mysql.connector.connect(host="cloudproject.ccgoqpzhjlfz.us-east-1.rds.amazonaws.com",user="CloudProject",passwd="cloudproject",db="CloudProject")

cursor = db.cursor()
# prepare a cursor object using cursor() method

def simlogin(limit,report):
    #CERT_FILE = '/Users/Geetesh/.ssh/projfirst.pem'
    headers = {"Content-type": "application/x-www-form-urlencoded", "Accept": "text/plain"}
    print("I was here")
    
    for i in range(1,limit+1):
        try:
            stmt="""SELECT userId,password FROM user WHERE userId = %d""" % (i) 
            cursor.execute(stmt,i)
            #credentials=cursor.fetchall()
            #print (credentials)
            jsonObject = json.loads(json.dumps(dict(cursor.fetchall())))    
            for key in jsonObject:
                url="https://www.ultronbankapp.net/CloudProject-3/Login.htm"
                payload={'userId':key,'password':jsonObject[key],}
                print("URLLL Working")
                res = requests.post("https://www.ultronbankapp.net/CloudProject-3/Login.htm", data=payload,verify=False)
                cookies=res.cookies
                print(res,key)
                #params = urllib.parse.urlencode({'username': row[0], 'password': row[1]})
                #conn = http.client.HTTPSConnection("LowCost-env.qkkr9vatxh.us-east-1.elasticbeanstalk.com")
                #conn.request("POST", "/login.htm", params, headers)
                #response1 = conn.getresponse()
                #data1 = response1.read()
                #print (response1.status, response1.reason)
                #print (data1)    
                for j in range(1,report+1):
                    url="https://www.ultronbankapp.net/CloudProject-3/BalanceDetails.htm"    
                    res1 = requests.get("https://www.ultronbankapp.net/CloudProject-3/BalanceDetails.htm", cookies=cookies,data=payload,verify=False)
                    print(res1,key)
                    #conn.request("GET","/viewCars.htm",params,headers)
                    #response = conn.getresponse()        
                    #data = response.read()
                    #print (response.status, response.reason)    
                    #print (data)
                    
                    
                        
##### iterative call get the users
        except:
            print ("error")

simlogin(3,2)
##### disconnect from server
db.close()