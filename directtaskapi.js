var apiPrefix      = require("../../../config").app.apiPrefix;
var serviceHandler = require("../serviceHandler").serviceHandler;
var jiq = require('../../../JioQ').createJioQ("brain");
var Promise=require("bluebird")
var config=require("../config");
function savedirecttask(req, res){
    var body = req.body;
    return Promise.resolve({status:"success",body:body})

}

function initAPIs(app){
    app.post(apiPrefix + '/directtasks', function(req, res) {
        serviceHandler(req, res,savedirecttask(req, res));
    });
}
module.exports = {
    init: function(app){
        return initAPIs(app);
    }
};
