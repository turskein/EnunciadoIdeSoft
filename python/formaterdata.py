import json
data = open("../data/data.txt","r")

everyJson = json.loads(str(data.read().replace("\n","")))
print(everyJson[0])

query = ""

for onejson in everyJson:
    query += "("
    for section in onejson:
        if(section == "local_id" or section == "fk_region" or section == "fk_comuna"):
            query += onejson[section]+","
        elif(section == "fk_localidad" ):
            query += onejson[section]
        else:
            query += "'"+onejson[section].replace("'","") +"',"
    query += "),\n"

querys = open("../data/query.txt","w")
querys.write(query)



