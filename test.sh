#!/bin/bash
echo "Realizando merge automatico con develop"
currentBranch=$(git branch --show-current)
echo "Rama actual es $currentBranch"
output=$(git pull origin master)
code=$?
echo $code
if [ $code -ne 0 ]; then
    echo "Error: Hubo problemas al hacer merge con develop (Posibles razones: contenido no commiteado o hubo conflicto de merge)"
    read;
    exit 1;
fi
echo "Merge automatico con develop realizado exitosamente"
git push
read;