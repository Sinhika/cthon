#!/bin/bash

# scripts are from mod_utils project on my GitHub.

ID='cthon'
NAME='Cthon'
TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != $NAME ]; then
    echo "Running in wrong directory!"
    exit 1
fi

# blockstates
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/blockstates
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# make simple blockstates
gen_blockstate_jsons.py --type=simple cthon_block
gen_blockstate_jsons.py --type=simple cthon_ore

# models
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/models
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# block models
gen_model_jsons.py --type=block cthon_block
gen_model_jsons.py --type=block cthon_ore

# inventory items
gen_model_jsons.py --type=inventory --item_only cthon_ingot
gen_model_jsons.py --type=inventory --item_only cthon_nugget
gen_model_jsons.py --type=inventory --item_only cthon_elutriated_chunk
gen_model_jsons.py --type=inventory --item_only cthon_mephitic_chunk

# tools
gen_model_jsons.py --type=tool --item_only cthon_sword
gen_model_jsons.py --type=tool --item_only cthon_shovel
gen_model_jsons.py --type=tool --item_only cthon_axe
gen_model_jsons.py --type=tool --item_only cthon_pickaxe
gen_model_jsons.py --type=tool --item_only cthon_hoe

# armor sets
gen_model_jsons.py --type=armor --item_only cthon_helmet
gen_model_jsons.py --type=armor --item_only cthon_chestplate
gen_model_jsons.py --type=armor --item_only cthon_leggings
gen_model_jsons.py --type=armor --item_only cthon_boots




