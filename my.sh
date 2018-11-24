#!/usr/bin/env bash


cust_func(){
  echo "Sleeping for $1 ..."
  sleep $1
  echo "Slept $1."
}

# For loop 5 times
j=5
for i in {1..5}
do
	cust_func $j & # Put a function in the background
    ((j--))
done

## Put all cust_func in the background and bash would wait until those are completed
## before displaying all done message
wait
echo "All done"
