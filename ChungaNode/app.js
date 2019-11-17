const express = require('express')
const app = express()
const morgan = require('morgan')
const mysql = require('mysql')

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    database: 'bd_almacen'
})

app.use(morgan('short'))

app.get("/users", (req, res) => {

    const queryString = "SELECT * FROM USUARIO"
    connection.query(queryString, (err, rows, fields) => {
        if (err) {
            console.log("ERROR EN => " + err)
            res.sendStatus(500)
            return
        }
        console.log("Listado de todos los usuarios successful")
        res.json(rows)
    })
})

app.get("/users/node", (req, res) => {

    const queryString = "SELECT * FROM USUARIO WHERE ORIGEN='API_NODEJS'"
    connection.query(queryString, (err, rows, fields) => {
        if (err) {
            console.log("ERROR EN => " + err)
            res.sendStatus(500)
            return
        }
        console.log("USUARIOS DE NODEJS")
        res.json(rows)
    })
})

app.post("/users/insert/", (req, res) => {

    const name = req.query.name
    const correo = req.query.correo
    const pass = req.query.pass

    const queryString = "INSERT INTO USUARIO VALUE(NULL,?,?,?,'Successful')"
    connection.query(queryString, [name, correo, pass], (err, rows, fields) => {
        if (err) {
            console.log("ERROR EN => " + err)
            res.sendStatus(500)
            return
        }
        console.log("Insert successful")
        res.send("Insertado")
    })
})

app.put("/users/update/", (req, res) => {

    const id = req.query.id
    const name = req.query.name
    const correo = req.query.correo
    const pass = req.query.pass

    const queryString = "UPDATE USUARIO SET NAME=?, CORREO=?, PASS=?, ORIGEN='Update Success' WHERE IDUSUARIO=?"
    connection.query(queryString, [name, correo, pass, id], (err, rows, fields) => {
        if (err) {
            console.log("ERROR EN => " + err)
            res.sendStatus(500)
            return
        }
        console.log("Updated successful")
        res.send("Successful")
    })
})

app.delete("/users/delete/", (req, res) => {

    const id = req.query.id

    const queryString = "DELETE FROM USUARIO WHERE IDUSUARIO=?"
    connection.query(queryString, [id], (err, rows, fields) => {
        if (err) {
            console.log("ERROR EN => " + err)
            res.sendStatus(500)
            return
        }
        console.log("Deleted successful")
        res.send("Deleted successful")
    })
})

app.get("/", (req, res) => {
    res.send("Server Mode ON")
})

app.listen()

// localhost 3002
app.listen(3002, () => {
    console.log("Running OK")
})