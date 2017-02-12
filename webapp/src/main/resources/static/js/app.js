/**
 * Created by Sharuru on 2017/2/12 0012.
 */
$(document).ready(function () {
    var table = $('#activity-table').DataTable({
        'ajax': '/data/activities',
        'serverSide': true,
        columns: [{
            data: 'id'
        }, {
            data: 'timestamp',
            render: function (data, type, row) {
                return new Date(data*1000).toLocaleString();
            }
        }, {
            data: 'type'
        }, {
            data: 'user'
        }, {
            data: 'affecteduser'
        }, {
            data: 'app'
        }, {
            data: 'subject'
        }, {
            data: 'file'
        }, {
            data: 'link'
        }, {
            data: 'objectType'
        }, {
            data: 'objectId'
        }]
    });
});