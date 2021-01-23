#!/bin/bash
echo "Realizando merge automatico con develop"
currentBranch=$(git branch --show-current)
echo "Rama actual es $currentBranch"
output=$(git pull origin master)
code=$?
if [ $code -ne 0 ]; then
    echo "Hubo conflictos al hacer merge con develop, es necesario resolver conflictos manualmente"
    read;
fi
echo "Merge automatico con develop realizado exitosamente"
git push
read;