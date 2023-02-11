#!/bin/bash

# mongoimport --db greetings --collection greetings --drop --jsonArray --file ./sample-data.json
mongoimport --db meme --collection meme --drop --jsonArray --file ./sample-data.json