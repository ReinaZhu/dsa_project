# dsa_project
### Project implementation and code analysis

I. Basic data processing
1. Read the json file, which shows that xx poems and xx authors have been read, including xx poets from the Tang Dynasty and xx poems, xx poets from the Song Dynasty and xx poems, etc.
The text in json format is read character by character through a loop, and the author, title and content are separated during reading and stored in the map. ArrayList is used to connect poems. There are 313 json files in total. Two authors introduce json files. ArrayList is also used to connect the files. ArrayList<ArrayList<Map>> is obtained. The poems read in are counted and exported to txt. (i.e. ReadIn.java file)
2. Provide query for an author and display list query results of all his poems
3. Query a certain keyword and display the query result list
4. Multi-keyword combination query, display query result list
5. Enter the txt file to query and display the query statistical results (enter the txt file to customize, please refer to poem75.txt)

II. tag classification function
1. Display the details of a poem and its tag content (can be empty)
2. Add or delete a tag of a poem
3. Query the keyword function of a certain tag
4. Create tags for multiple poems in batches from given txt files
              
III． Learning process simulation
1. Display the list of all poems in the learning simulation (title and author), no less than 100 poems
2.1 Specify, select from query results such as title, author, content, etc.
2.2 Random, must not appear as having learned (100% proficiency) or currently learning (0<proficiency<100%)
2.3 According to the recommended list in the learned poem tag, you should not recommend only one poem
3. Review, display the poems to be reviewed, and display the proficiency of each poem
4. Feedback on new proficiency after learning
Each time you click on the learning results display in the main menu, use jtree to create a tree based on user.studylist (the method private void set Appearance() in ResultFrame is the tree building method) with the user name root, which is divided into a learning list, a review list, and an unlearned list. , proficiency list and recommendation list, the proficiency level is changed every time you learn a new poem, and the proficiency level is classified into the corresponding branches and displayed. Each time this window is opened, the list is re-read and the tree is created.
Whenever the mouse clicks on a poem (leaf), the node.tostring is obtained through monitoring and stored in a global variable. When you click "View the poem" again, it will jump to the learning page of the poem. If you click on non-leaf or "None", then click "View the poem" and there will be no response. If you click on multiple poems, the learning interface of the last clicked poem will be opened.
