#python 3.5
import http.client

url = "localhost:7777"

#get
conn = http.client.HTTPConnection(url)
conn.request("GET","/")
content = conn.getresponse().read()

print(content)

#post
conn2 = http.client.HTTPConnection(url)
conn2.request("POST","/post",'{"number" : "7"}',{"Content-type" : "application/json"})
content2 = conn2.getresponse().read()

print(content2)
