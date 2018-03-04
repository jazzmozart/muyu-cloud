/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
    // Define changes to default configuration here.
    // For complete reference see:
    // http://docs.ckeditor.com/#!/api/CKEDITOR.config

    // The toolbar groups arrangement, optimized for two toolbar rows.
    config.toolbarGroups = [
        { name: 'document', groups: [ 'Print' ] },
        { name: 'clipboard', groups: [ 'Undo', 'Redo' ] },
        { name: 'styles', groups: [ 'Format', 'Font', 'FontSize' ] },
        { name: 'basicstyles', groups: [ 'Bold', 'Italic', 'Underline', 'Strike', 'RemoveFormat', 'CopyFormatting' ] },
        { name: 'colors', groups: [ 'TextColor', 'BGColor' ] },
        { name: 'align', groups: [ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
        { name: 'links', groups: [ 'Link', 'Unlink' ] },
        { name: 'paragraph', groups: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote' ] },
        { name: 'insert', groups: [ 'Image', 'Table', 'Code' ] },
        { name: 'tools', groups: [ 'Maximize' ] },
        { name: 'editing', groups: [ 'Scayt' ] }
    ];

    config.height = 800;

    config.contentsCss = ['https://cdn.ckeditor.com/4.8.0/full-all/contents.css', '/oss/ckeditor/editor.css' ];

    config.colorButton_colors = 'CF5D4E,454545,FFF,CCC,DDD,CCEAEE,66AB16';
    config.colorButton_enableAutomatic = false;


    config.bodyClass = "document-editor";
    // Remove some buttons provided by the standard plugins, which are
    // not needed in the Standard(s) toolbar.
    config.removeButtons = 'Underline,Subscript,Superscript';

    // Set the most common block elements.
    config.format_tags = 'p;h1;h2;h3;pre';

    // Simplify the dialog windows.
    config.removeDialogTabs = 'image:advanced;link:advanced';

    config.disallowedContent = 'img{width,height,float}';
    config.extraAllowedContent = 'img[width,height,align]';

    config.disallowedContent = 'img{width,height,float}';
    config.extraAllowedContent = 'img[width,height,align]';

    config.uploadUrl = '/backend/article/images';
    config.filebrowserImage2UploadUrl = '/upload';

    config.save

    config.extraPlugins = 'tableresize,uploadimage,uploadfile,codesnippet,markdown';

    config.stylesSet = [
        /* Inline Styles */
        { name: 'Marker', element: 'span', attributes: { 'class': 'marker' } },
        { name: 'Cited Work', element: 'cite' },
        { name: 'Inline Quotation', element: 'q' },
        /* Object Styles */
        {
            name: 'Special Container',
            element: 'div',
            styles: {
                padding: '5px 10px',
                background: '#eee',
                border: '1px solid #ccc'
            }
        },
        {
            name: 'Compact table',
            element: 'table',
            attributes: {
                cellpadding: '5',
                cellspacing: '0',
                border: '1',
                bordercolor: '#ccc'
            },
            styles: {
                'border-collapse': 'collapse'
            }
        },
        { name: 'Borderless Table', element: 'table', styles: { 'border-style': 'hidden', 'background-color': '#E6E6FA' } },
        { name: 'Square Bulleted List', element: 'ul', styles: { 'list-style-type': 'square' } }
    ]
};