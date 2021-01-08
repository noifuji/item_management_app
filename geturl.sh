#!/bin/sh
ip=$(curl -q http://169.254.169.254/latest/meta-data/public-ipv4)
echo "http://$ip/ItemManagement/"